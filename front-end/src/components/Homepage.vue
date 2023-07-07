<script>
import axios from 'axios';

export default {
      name: 'Homepage',
      data() {
            return {
                  api: 'http://localhost:8080/api/',
                  photos: []
            }
      },
      created() {

            axios
                  .get(this.api + 'photos')
                  .then(response => {
                        console.log(response.data);
                        this.photos = response.data;
                  })
      }
}
</script>

<template>
      <div class="container">
            <div class="row mt-3">
                  <div v-for="photo in photos" class="col-3">
                        <div class="card">
                              <img :src="photo.url" class="card-img-top" :alt="photo.title">
                              <div class="card-body">
                                    <h5 class="card-title">{{ photo.title }}</h5>
                                    <p class="card-text">{{ photo.description }}</p>
                              </div>

                              <ul>
                                    <li v-for="category in photo.categories">
                                          {{ category.name }}
                                    </li>
                              </ul>
                        </div>
                  </div>
            </div>
      </div>
</template>

<style lang="scss"></style>