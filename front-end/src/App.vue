<script>
import Navbar from './components/Navbar.vue';
import Homepage from './components/Homepage.vue';

export default {
      name: 'App',
      components: {
            Navbar,
            Homepage
      }
}
</script>

<template>
      <Navbar />

      <Homepage />
</template>

<style lang="scss">
@import './styles/main.scss';
</style>
