<template>
  <div class="category-contacts">
    <div class="category-name">
      <h2>{{ name }}</h2>
    </div>
    <div class="row">
      <div
        v-for="user in users"
        :key="user.id"
        class="col-lg-4 col-md-6 col-sm-12 mb-4"
      >
        <contact>
          <contact-position v-if="user.positions">
            {{ user.positions.name }}
          </contact-position>

          <contact-name
            v-if="user.name && user.patronicName"
            :name="user.name"
            :patronicname="user.patronicName"
            :surname="user.surName"
            direction="column"
          ></contact-name>

          <contact-info-list
            :room="user.room"
            :phone="user.phone"
            :email="user.email"
          ></contact-info-list>

          <contact-note v-if="user.contact.note">
            {{ user.contact.note }}
          </contact-note>
        </contact>
      </div>
    </div>
  </div>
</template>

<script>
import Contact from '@/components/Contact/index.vue';
import ContactPosition from '@/components/Contact/ContactPosition.vue';
import ContactName from '@/components/Contact/ContactName.vue';
import ContactInfoList from '@/components/Contact/ContactInfoList.vue';
import ContactNote from '@/components/Contact/ContactNote.vue';

export default {
  name: 'CategoryContacts',
  components: {
    Contact,
    ContactPosition,
    ContactName,
    ContactInfoList,
    ContactNote,
  },
  props: {
    name: String,
    users: Array,
  },
};
</script>

<style lang="stylus" scoped>
.category-contacts {
  margin-bottom: 3rem;

  .category-name {
    margin-bottom: 2rem;

    h2 {
      font-weight: 200;
    }
  }
}
</style>
