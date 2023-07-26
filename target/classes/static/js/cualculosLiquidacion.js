function calcularMonto(dctoInst) {
	return function () {
		const sueldoImponible = parseFloat(document.getElementById('imponible').value);
		const select = document.getElementById(`id${dctoInst}`);
		const dctoPorcentaje = parseFloat(
			select.options[select.selectedIndex].getAttribute(`data-${dctoInst.toLowerCase()}`)
		);

		const montoDcto = sueldoImponible * (dctoPorcentaje / 100);
		document.getElementById(`monto${dctoInst}`).value = montoDcto.toFixed(0);

		const ttalDescuento =
			parseFloat(document.getElementById('montoAfp').value) +
			parseFloat(document.getElementById('montoSalud').value);
		document.getElementById(`ttalDctos`).value = ttalDescuento.toFixed(0);

		const anticipoSolicitado = parseFloat(document.getElementById('anticipo').value);
		document.getElementById(`haberes`).value = sueldoImponible.toFixed(0);

		const ttalLiquido = sueldoImponible - ttalDescuento - anticipoSolicitado;
		document.getElementById(`liquido`).value = ttalLiquido.toFixed(0);
	};
}

document.getElementById('imponible').addEventListener('input', calcularMonto('Afp'));
document.getElementById('idAfp').addEventListener('change', calcularMonto('Afp'));
document.getElementById('idSalud').addEventListener('change', calcularMonto('Salud'));
document.getElementById('anticipo').addEventListener('input', calcularMonto('Afp'));
