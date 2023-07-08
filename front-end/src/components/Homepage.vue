<script>
import axios from 'axios';

export default {
      name: 'Homepage',
      data() {
            return {
                  api: 'http://localhost:8080/api/',
                  search: "",
                  photos: [],
                  message: {
                        email: "",
                        text: ""
                  },
                  modalMessage: ""
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
            },

            postMessage() {
                  axios
                        .post(this.api + 'messages', {
                              email: this.message.email,
                              text: this.message.text
                        })
                        .then(response => {
                              console.log(response);
                              if (response.status == 200) {
                                    this.message.email = "";
                                    this.message.text = "";
                                    this.modalMessage = "Messaggio inviato correttamente";
                                    this.openModal();
                              }
                        })
                        .catch(error => {
                              console.log(error);
                              this.modalMessage = "Errore nel invio del messaggio! Controllare che i campi siano correttamente compilati";
                              this.openModal();
                        })
            },

            // metodo per visualizzare messaggio ad invio messaggio
            openModal() {
                  const modal = document.getElementById('exampleModal');
                  modal.classList.add('show');
                  modal.setAttribute('aria-hidden', 'false');
                  modal.style.display = 'block';
            },

            // metodo per chiudere il modale
            closeModal() {
                  const modal = document.getElementById('exampleModal');
                  modal.classList.remove('show');
                  modal.setAttribute('aria-hidden', 'true');
                  modal.style.display = 'none';
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

            <!-- Offcanvas con form messaggi -->
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                  <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasRightLabel">Inviami un messaggio</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                  </div>
                  <div class="offcanvas-body">

                        <form @submit.prevent>
                              <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Indirizzo email</label>
                                    <input v-model="message.email" type="email" class="form-control"
                                          id="exampleFormControlInput1" placeholder="name@example.com">
                              </div>
                              <div class="mb-3">
                                    <label for="exampleFormControlTextarea1" class="form-label">Testo messaggio</label>
                                    <textarea v-model="message.text" class="form-control" id="exampleFormControlTextarea1"
                                          rows="10"></textarea>
                              </div>
                              <button @click="postMessage" class="btn btn-primary">Invia</button>
                        </form>

                  </div>
            </div>

            <!-- modale invio messaggio avvenuto correttamente -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                        <div class="modal-content">
                              <div class="modal-body text-center pt-4"
                                    :class="modalMessage == 'Messaggio inviato correttamente' ? 'text-success' : 'text-danger'">
                                    {{ modalMessage }}
                              </div>
                              <div class="modal-footer">
                                    <button @click="closeModal" type="button" class="btn btn-secondary"
                                          data-bs-dismiss="modal">Close</button>
                              </div>
                        </div>
                  </div>
            </div>
      </div>
</template>

<style lang="scss"></style>