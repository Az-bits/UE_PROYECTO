<form action="PersonaControlador" method="post">
    <div class="p-3 border-radius-xl bg-white js-active"   >
        <h5 class="font-weight-bolder mb-0">Personas</h5>
        <p class="mb-0 text-sm">Informaciones obligatorias</p>
        <div class="multisteps-form__content">
            <div class="row mt-3"> 
                <input type="hidden" name="action" value="${action}"/>
                <input name="persona_nro" type="hidden" value="${persona.persona_nro}"  />
                <div class="col-12 col-sm-6">
                    <label>Cedula de Identidad</label>
                    <input class="form-control" name="ci" type="text" value="${persona.ci}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Nombre</label>
                    <input class="form-control" name="nombre" type="text" value="${persona.nombre}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Paterno</label>
                    <input class="form-control" name="paterno" type="text" value="${persona.paterno}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6 mt-3 mt-sm-0">
                    <label>Materno</label>
                    <input class="form-control" name="materno" type="text" value="${persona.materno}" placeholder="" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12 col-sm-6">
                    <label>Fecha Nacimiento</label>
                    <input class="form-control" name="fecha_nac"  type="date" placeholder="" value="${persona.fecha_nac}" />
                </div>
                <div class="col-12 col-sm-6 mt-3 mt-sm-0">
                    <label>Direccion</label>
                    <input class="form-control" name="direccion" type="direccion" value="${persona.direccion}" placeholder="" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12 col-sm-6">
                    <label>Telefono</label>
                    <input class="form-control" name="telefono"  type="number" value="${persona.telefono}" placeholder="" />
                </div>  
            </div>
            <div class="button-row d-flex mt-4">
                <a href="PersonaControlador" class="btn bg-gradient-danger mb-0 js-btn-next"><i class="fa-solid fa-xmark"></i> Cancelar</a>
                <button class="btn bg-gradient-dark ms-auto mb-0 js-btn-next" type="submit" title="Next"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
            </div>
        </div>
    </div>
</form>