<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String action = request.getParameter("action");
%>
<div class="row mt-4 ">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
                <h5 class="mb-0">Listado de administrativos</h5>
                <p class="text-sm mb-0">
                    Puede realizar la gestion de los administrativos
                </p>
                <div class="d-flex align-items-center mt-3">
                    <a href="AdministrativoControlador?vista=frmAdministrativo&action=add" class="btn bg-gradient-primary"><i class="fa-solid fa-plus"></i> nuevo</a>
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
                                            >N�</a
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
                                            >Cargo</a
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
                                                >Administrativo</a
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
                                <c:forEach var="item" items="${administrativo}">
                                    <tr>
                                        <td class="text-sm font-weight-normal">
                                            ${item.administrativo_nro}
                                        </td>
                                         <td class="text-sm font-weight-normal">
                                            ${item.cargo}
                                        </td>
                                        <td class="text-sm font-weight-normal">
                                            ${item.administrativo}
                                        </td>
                                            <td class="text-sm font-weight-normal">
                                            <a href="AdministrativoControlador?action=edit&administrativo_nro=${item.administrativo_nro}&vista=frmAdministrativo" class="btn bg-gradient-info btn-sm">
                                                <i class="fa-solid fa-pencil" style="font-size: 1rem;"></i>
                                            </a>
                                            <a href="AdministrativoControlador?action=delete&administrativo_nro=${item.administrativo_nro}" onclick="return(confirm('Estas seguro de eliminar'))" class="btn bg-gradient-danger btn-sm">
                                                <i class="fa-solid fa-trash" style="font-size: 1rem;"></i>
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