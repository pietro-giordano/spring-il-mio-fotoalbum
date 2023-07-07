<script>
export default {
      name: 'Navbar'
}

</script>

<template>
      <nav class="navbar navbar-expand-lg container">
            <div class="container-fluid">
                  <a class="navbar-brand" href="#">Album fotografico</a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                              <li class="nav-item">
                                    <a class="nav-link active" href="#">Foto</a>
                              </li>
                              <li class="nav-item">
                                    <a class="nav-link" href="#">Contatta</a>
                              </li>
                        </ul>
                  </div>
            </div>
      </nav>
</template>

<style lang="scss"></style>