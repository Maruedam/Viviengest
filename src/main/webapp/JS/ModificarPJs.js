/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
x = new Boolean(false); 
$("#cancelar").click(function () {
    var form = document.getElementById("formulario");
    form.action = "EditarPropietario";
    form.submit();
});
$("#modif").click(function () {
    var form = document.getElementById("formulario");
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var passwd = document.getElementById("passwd").value;
    var telefono = document.getElementById("telefono").value;

    var numecuenta = document.getElementById("numecuenta").value;
    var direccionpostal = document.getElementById("direccionpostal").value;



    if (nombre.length < 1 || apellidos.length < 1 || passwd.length < 1 || telefono.length < 1 || numecuenta.length < 1 || direccionpostal.length < 1) {

        x = false;
        $("#error").empty();
        $("#error").append("Rellene todos los capos por favor");
    } else {

        x = true;
    }

    if (x) {
        form.action = "EditarPropietario";
        form.submit();
    }
    return x;
});




