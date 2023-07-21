function confirmDelete() {
    swal({
        title: "¿Seguro que quieres eliminar?",
        text: "¡Los datos eliminados no se podrán recuperar!",
        type: "warning",
        showCancelButton: true,
        confirmButtonClass: "btn-danger",
        confirmButtonText: "SI! Elimínalo!",
        closeOnConfirm: false
        },
        function(){
            document.forms[0].submit();
            swal("¡ELIMINADO!", "Los datos fueron eliminados con éxito", "success");
        });
    alert("¡Hola desde miFuncion()!");
/*
    })
        .then((willDelete) => {
            if (willDelete) {
                // Aquí puedes agregar el código para eliminar algo
                swal("¡Eliminado!", {
                    icon: "success",
                });
            } else {
                swal("¡Cancelado!");
            }
        });*/
}
