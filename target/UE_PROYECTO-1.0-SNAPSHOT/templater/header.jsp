 <%
    String pagina = request.getParameter("pagina");
%>
<nav
        class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl"
        id="navbarBlur"
        navbar-scroll="true"
      >
        <div class="container-fluid py-1 px-3">
          <nav aria-label="breadcrumb">
            <ol
              class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5"
            >
              <li class="breadcrumb-item text-sm">
                <a class="opacity-5 text-dark" href="javascript:;">Edrei</a>
              </li>
              <li
                class="breadcrumb-item text-sm text-dark active"
                aria-current="page"
              >
                <%= pagina.substring(0, 1).toUpperCase() + pagina.substring(1).toLowerCase() %>
              </li>
            </ol>
            <h6 class="font-weight-bolder mb-0"><%= pagina.substring(0, 1).toUpperCase() + pagina.substring(1).toLowerCase() %></h6>
          </nav>
          <div
            class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4"
            id="navbar"
          >
            <div class="ms-md-auto pe-md-3 d-flex align-items-center">
              <div class="input-group">
                <span class="input-group-text text-body"
                  ><i class="fas fa-search" aria-hidden="true"></i
                ></span>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Buscar..."
                />
              </div>
            </div>
            <ul class="navbar-nav justify-content-end">
              <li class="nav-item d-flex align-items-center">
                <a
                  class="btn btn-outline-primary btn-sm mb-0 me-3"
                  target="_blank"
                  href="https://www.creative-tim.com/builder?ref=navbar-soft-ui-dashboard"
                  >Pagina Principal</a
                >
              </li>
              <li class="nav-item d-flex align-items-center">
                <a
                  href="javascript:;"
                  class="nav-link text-body font-weight-bold px-0"
                >
                  <i class="fa fa-user me-sm-1"></i>
                  <span class="d-sm-inline d-none">Sign In</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>