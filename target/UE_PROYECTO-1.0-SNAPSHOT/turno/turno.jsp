<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row mt-4 ">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
                <h5 class="mb-0">Listado de Turnos</h5>
                <p class="text-sm mb-0">
                    Puede realizar la gestion de turnos
                </p>
                <div class="d-flex align-items-center mt-3">
                    <a href="TurnoControlador?vista=frmTurno&action=add" class="btn bg-gradient-primary"><i class="fa-solid fa-plus"></i> nuevo</a>
                </div>
            </div>
            <div class="table-responsive">
                <div
                    class="dataTable-wrapper dataTable-loading no-footer sortable fixed-height fixed-columns"
                    >
                    <div class="dataTable-container" style="height: 498.265px">
                        <table
                            class="table table-flush dataTable-table"
                            id="datatable-basic"
                            >
                            <thead class="thead-light">
                                <tr>
                                    <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                        data-sortable=""
                                        style="width: 19.935%"
                                        >
                                        <a
                                            href=#"
                                            class="dataTable-sorter"
                                            >Nº</a
                                        >
                                    </th>
                                     <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                        data-sortable=""
                                        style="width: 19.935%"
                                        >
                                        <a
                                            href=#"
                                            class="dataTable-sorter"
                                            >Turno</a
                                        >
                                    </th>
                                    <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                        data-sortable=""
                                        style="width: 27.4756%"
                                        >
                                        <a
                                            href=#"
                                            class="dataTable-sorter"
                                            >Entrada</a
                                        >
                                    </th>
                                       <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                        data-sortable=""
                                        style="width: 27.4756%"
                                        >
                                        <a
                                            href=#"
                                            class="dataTable-sorter"
                                            >Salida</a
                                        >
                                    </th>
                                    <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                        data-sortable=""
                                        style="width: 13.0878%"
                                        >
                                        <a href="javascript:;" class="dataTabl-sorter" data-toggle="tooltip" data-original-title="Edit user">
                                            Acciones
                                        </a>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${turno}">
                                    <tr>
                                        <td class="text-sm font-weight-normal">
                                            ${item.turno_nro}
                                        </td>
                                         <td class="text-sm font-weight-normal">
                                            ${item.turno}
                                        </td>
                                        <td class="text-sm font-weight-normal">
                                            ${item.entrada}
                                        </td>
                                         <td class="text-sm font-weight-normal">
                                            ${item.salida}
                                        </td>
                                        <td class="text-sm font-weight-normal">
                                            <a href="TurnoControlador?action=edit&turno_nro=${item.turno_nro}&vista=frmTurno" class="btn bg-gradient-info btn-sm">
                                                <i class="fa-solid fa-pencil" style="font-size: 1rem;"></i>
                                            </a>
                                            <a href="TurnoControlador?action=delete&turno_nro=${item.turno_nro}" onclick="return(confirm('Estas seguro de eliminar'))" class="btn bg-gradient-danger btn-sm">
                                                 <i class="fa-solid fa-trash" style="font-size: 1rem;"  ></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div> 
                </div>
            </div>
        </div>
    </div>
</div>