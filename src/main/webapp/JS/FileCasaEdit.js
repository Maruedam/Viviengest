/* global waitingDialog */

if (typeof imagenInput === 'undefined') {
    var imagenInput;
}


document.getElementById("fileCasa").onchange = function (e) {
    // Creamos el objeto de la clase FileReader
    let reader = new FileReader();
    var nuevoCSS = {"width": '100', "height": '100'};
    // Leemos el archivo subido y se lo pasamos a nuestro fileReader
    reader.readAsDataURL(e.target.files[0]);

    // Le decimos que cuando este listo ejecute el código interno
    reader.onload = function () {
        let preview = document.getElementById('previa');
        preview.innerHTML = '';
        preview.append(reader.result);
    };
};




$(document).ready(function () {
    let original = $('#previa').attr('src');
    let selloTiempo = new Date();

    $('#previa').attr('src', original + '?' + selloTiempo);
    $('#fileCasa').on('change', function () {
        readURL(this);
    });
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            imagenInput = e.target.result;
//            let selloTiempo = new Date();
//            $("#myimg").attr("src", "/myimg.jpg?"+d.getTime());
//            $('#previa').attr('src', e.target.result+'?'+selloTiempo.getTime());
            $('#previa').attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

x = new Boolean(false);
z = new Boolean(false);
$("#cancelar").click(function () {
    var form = document.getElementById("formulario");
    form.action = "OperacionesVivienda";
    form.submit();
});
$("#editar").click(function () {
    var form = document.getElementById("formulario");
    var direccion = document.getElementById("direccion").value;
    var cPostal = document.getElementById("cPostal").value;
    var localidad = document.getElementById("localidad").value;
    var provincia = document.getElementById("provincia").value;
    var nHabitaciones = document.getElementById("nHabitaciones").value;
    var tipoDeSuelo = document.getElementById("tipoDeSuelo").value;
    var nBanios = document.getElementById("nBanios").value;
    var metrosCuadrados = document.getElementById("metrosCuadrados").value;
    var minimoMeses = document.getElementById("minimoMeses").value;
    var importeMensual = document.getElementById("importeMensual").value;
    var importeFinaza = document.getElementById("importeFinaza").value;
    var anioContruccion = document.getElementById("anioContruccion").value;


    if (validaNombreApellidos(direccion) || validaNombreApellidos(cPostal) || validaNombreApellidos(localidad) || validaNombreApellidos(provincia) || validaNombreApellidos(nHabitaciones)
            || validaNombreApellidos(tipoDeSuelo) || validaNombreApellidos(nBanios) || validaNombreApellidos(metrosCuadrados) || validaNombreApellidos(minimoMeses)
            || validaNombreApellidos(importeMensual) || validaNombreApellidos(importeFinaza) || validaNombreApellidos(anioContruccion)) {

        z = false;
        $("#error").empty();
        $("#error").append("Rellene todos los capos por favor");
    } else {

        z = true;
    }

    if (z) {
        form.action = "OperacionesVivienda";
        form.submit();
    }
    return z;
});


function validaNombreApellidos(nombre) {
    if (nombre.length < 1) {
        $("#error").empty();
        $("#error").append("Rellene todos los capos por favor");
        x = true;
    }else{
        x=false;
    }
    return x;
}