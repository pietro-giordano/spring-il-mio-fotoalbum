<script>
import axios from 'axios';

export default {
      name: 'Homepage',
      data() {
            return {
                  api: 'http://localhost:8080/api/',
                  search: "",
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
      },
      methods: {

            input() {
                  axios
                        .get(this.api + 'photos', {
                              params: {
                                    name: this.search
                              }
                        })
                        .then(response => {
                              console.log(response.data);
                              this.photos = response.data;
                        })
            }
      }
}
</script>

<template>
      <div class="container">
            <div class="col-4">
                  <input v-model="search" @keyup="input()" class="form-control me-2" type="text"
                        placeholder="Filtra foto per nome...">
            </div>

            <div class="row mt-3 d-flex">
                  <div v-for="photo in photos" class="col-3 mb-4">
                        <div class="card p-3" style="height: 350px;">
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