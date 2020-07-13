import { uploadFileEditor } from '@/api/file';
import store from '@/store';

import Essentials from '@ckeditor/ckeditor5-essentials/src/essentials';
import Bold from '@ckeditor/ckeditor5-basic-styles/src/bold';
import Italic from '@ckeditor/ckeditor5-basic-styles/src/italic';
import Underline from '@ckeditor/ckeditor5-basic-styles/src/underline';
import Strikethrough from '@ckeditor/ckeditor5-basic-styles/src/strikethrough';
import Subscript from '@ckeditor/ckeditor5-basic-styles/src/subscript';
import Superscript from '@ckeditor/ckeditor5-basic-styles/src/superscript';
import Code from '@ckeditor/ckeditor5-basic-styles/src/code';

import Heading from '@ckeditor/ckeditor5-heading/src/heading';
import Link from '@ckeditor/ckeditor5-link/src/link';
import Paragraph from '@ckeditor/ckeditor5-paragraph/src/paragraph';

import Indent from '@ckeditor/ckeditor5-indent/src/indent';
import IndentBlock from '@ckeditor/ckeditor5-indent/src/indentblock';

import EasyImage from '@ckeditor/ckeditor5-easy-image/src/easyimage';
import Image from '@ckeditor/ckeditor5-image/src/image';
import ImageToolbar from '@ckeditor/ckeditor5-image/src/imagetoolbar';
import ImageCaption from '@ckeditor/ckeditor5-image/src/imagecaption';
import ImageStyle from '@ckeditor/ckeditor5-image/src/imagestyle';
import ImageResize from '@ckeditor/ckeditor5-image/src/imageresize';

import Table from '@ckeditor/ckeditor5-table/src/table';
import TableToolbar from '@ckeditor/ckeditor5-table/src/tabletoolbar';

import Alignment from '@ckeditor/ckeditor5-alignment/src/alignment';

import MediaEmbed from '@ckeditor/ckeditor5-media-embed/src/mediaembed';

import List from '@ckeditor/ckeditor5-list/src/listui';
import TodoList from '@ckeditor/ckeditor5-list/src/todolist';

import SimpleUploadAdapter from '@ckeditor/ckeditor5-upload/src/adapters/simpleuploadadapter';

export const EditorConfig = {
  plugins: [
    Essentials,
    Bold,
    Italic,
    Underline,
    Strikethrough,
    Subscript,
    Superscript,
    Code,
    Heading,
    Link,
    Paragraph,
    Indent,
    IndentBlock,
    EasyImage,
    Image,
    ImageToolbar,
    ImageCaption,
    ImageStyle,
    ImageResize,
    Table,
    TableToolbar,
    Alignment,
    MediaEmbed,
    List,
    TodoList,
    SimpleUploadAdapter,
  ],
  indentBlock: {
    offset: 1,
    unit: 'em',
  },
  image: {
    toolbar: [
      'imageStyle:full',
      'imageStyle:side',
      '|',
      'imageTextAlternative',
    ],
  },
  simpleUpload: {
    uploadUrl: uploadFileEditor(),
    headers: {
      Authorization: `Bearer ${store.getters.token}`,
    },
  },
  table: {
    contentToolbar: ['tableColumn', 'tableRow', 'mergeTableCells'],
  },
  toolbar: {
    viewportTopOffset: 50,
    items: [
      'undo',
      'redo',
      '|',
      'heading',
      '|',
      'bold',
      'italic',
      'underline',
      'strikethrough',
      'link',
      '|',
      'numberedlist',
      'bulletedList',
      '|',
      'insertTable',
      '|',
      'outdent',
      'indent',
      'alignment',
      '|',
      'imageUpload',
      'mediaEmbed',
      '|',
      'subscript',
      'superscript',
      'code',
    ],
  },
};
