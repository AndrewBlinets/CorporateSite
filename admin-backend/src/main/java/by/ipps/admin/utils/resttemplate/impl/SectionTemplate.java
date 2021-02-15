package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.entity.Block;
import by.ipps.admin.entity.BlockForFront;
import by.ipps.admin.entity.BlockLanVer;
import by.ipps.admin.entity.Section;
import by.ipps.admin.entity.SectionForCreate;
import by.ipps.admin.entity.SectionLanguageVersion;
import by.ipps.admin.utils.resttemplate.SectionRestTemplate;
import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SectionTemplate extends AbstractBaseEntityRestTemplate<Section>
    implements SectionRestTemplate {

  @Autowired private ModelMapper modelMapper;

  @Override
  public ResponseEntity<List<Section>> findSectionByIdPage(long id) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/section/getByIdPage/" + id);
    final ParameterizedTypeReference<List<Section>> responseType =
        new ParameterizedTypeReference<List<Section>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<Section> create(Section entity, String url, long idUser) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "create/" + entity.getPage())
            .queryParam("user", String.valueOf(idUser));
    SectionForCreate create = modelMapper.map(entity, SectionForCreate.class);
    List<Block> blocks = new ArrayList<>();
    for (BlockForFront blockForFront : create.getLanguageVersions().get(0).getBlocks()) {
      blocks.add(new Block(blockForFront.getIndex(), create.getStatus()));
    }
    for (SectionLanguageVersion sectionLanguageVersion : create.getLanguageVersions()) {
      for (BlockForFront blockForFront : sectionLanguageVersion.getBlocks()) {
        for (Block block : blocks) {
          if (block.getIndex() == blockForFront.getIndex()) {
            block
                .getLanguageVersions()
                .add(
                    new BlockLanVer(
                        blockForFront.getContent(), sectionLanguageVersion.getCodeLanguage()));
          }
        }
      }
    }
    create.setBlocks(blocks);
    HttpEntity<SectionForCreate> requestEntity = new HttpEntity<>(create, getHttpHeaders());
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, Section.class);
  }

  @Override
  public ResponseEntity<Section> update(Section entity, String url, long idUser) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "update/" + entity.getPage())
            .queryParam("user", String.valueOf(idUser));
    SectionForCreate create = modelMapper.map(entity, SectionForCreate.class);
    List<Block> blocks = new ArrayList<>();
    for (BlockForFront blockForFront : create.getLanguageVersions().get(0).getBlocks()) {
      blocks.add(new Block(blockForFront.getIndex(), create.getStatus(), blockForFront.getId()));
    }
    for (SectionLanguageVersion sectionLanguageVersion : create.getLanguageVersions()) {
      for (BlockForFront blockForFront : sectionLanguageVersion.getBlocks()) {
        for (Block block : blocks) {
          if (block.getId() == blockForFront.getId()) {
            block
                .getLanguageVersions()
                .add(
                    new BlockLanVer(
                        blockForFront.getIdLanguageVersion(),
                        blockForFront.getContent(),
                        sectionLanguageVersion.getCodeLanguage()));
          }
        }
      }
    }
    create.setBlocks(blocks);
    HttpEntity<SectionForCreate> requestEntity = new HttpEntity<>(create, getHttpHeaders());
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.PUT, requestEntity, Section.class);
  }

  private HttpHeaders getHttpHeaders() {
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    return requestHeaders;
  }
}
