/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
x = new Boolean(false);
z = new Boolean(false);
$("#cancelar").click(function () {
    var form = document.getElementById("formulario");
    form.action = "EditarInquilino";
    form.submit();
});
$("#modif").click(function () {
    var form = document.getElementById("formulario");
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var passwd = document.getElementById("passwd").value;
    var telefono = document.getElementById("telefono").value;
    var ultimaNomina = document.getElementById("nomina").value;

    if ( nombre.length < 1 || apellidos.length < 1 || passwd.length < 1 ||  telefono.length < 1 || ultimaNomina.length < 1) {

        x= false;
        $("#error").empty();
        $("#error").append("Rellene todos los capos por favor");
    } else {

        x = true;
    }

    if (x) {
        form.action = "EditarInquilino";
        form.submit();
    }
    return x;
});




