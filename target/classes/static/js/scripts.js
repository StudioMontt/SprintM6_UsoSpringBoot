function confirmDeleteScript(form) {
	Swal.fire({
		title: '¿Seguro que quieres eliminar?',
		text: '¡Los datos eliminados no se podrán recuperar!',
		type: 'warning',
		showCancelButton: true,
		confirmButtonClass: 'btn-danger',
		confirmButtonText: 'SI! Elimínalo!',
		closeOnConfirm: false,
	}).then((result) => {
		if (result.isConfirmed) {
			Swal.fire('Eliminado!', '¡Los datos fueron eliminados con éxito!', 'success');
			setTimeout(function () {
				form.submit();
			}, 3500);
		}
	});
}
