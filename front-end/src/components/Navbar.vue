<script>
export default {
      name: 'Navbar'
}

</script>

<template>
      <nav class="navbar navbar-expand-lg container">
            <div class="container-fluid">
                  <a class="navbar-brand" href="/">Album fotografico</a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarNav">
                        <ul class="navbar-nav">
                              <li class="nav-item nav-link" role='button' data-bs-toggle="offcanvas"
                                    data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                                    Contattami
                              </li>
                              <li class="nav-item">
                                    <a class="nav-link" href="http://localhost:8080">Area riservata</a>
                              </li>
                              <li class="nav-item">
                                    <a class="nav-link" href="http://localhost:8080/register">Registrati</a>
                              </li>
                        </ul>
                  </div>
            </div>
      </nav>
</template>

<style lang="scss"></style>