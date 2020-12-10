/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
x = new Boolean(false);
z = new Boolean(true);
$("#cancelar").click(function () {
    var form = document.getElementById("formulario");
    form.action = "index.jsp";
    form.submit();
});
$("#crear").click(function () {
    var form = document.getElementById("formulario");
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var dni = document.getElementById("nif").value;
    var email = document.getElementById("email").value;
    var passwd = document.getElementById("passwd").value;
    var telefono = document.getElementById("telefono").value;

    if (document.getElementById("ultimaNomina") === null) {
        var numecuenta = document.getElementById("numecuenta").value;
        var direccionpostal = document.getElementById("direccionpostal").value;
        if (numecuenta.length < 1 || direccionpostal.length < 1) {
            $("#error").empty();
            $("#error").append("Rellene todos los capos por favor");
            z = false;
        } else {
            z = true;
        }

    } else {
        var ultimaNomina = document.getElementById("ultimaNomina").value;
        if (ultimaNomina.length < 1) {
            $("#error").empty();
            $("#error").append("Rellene todos los capos por favor");
            z = false;
        } else {
            z = true;
        }
    }

    if (validaDni(dni) || nombre.length < 1 || apellidos.length < 1 || email.length < 1 || passwd.length < 1 || telefono.length < 1 || z === false) {

        z = false;
    } else {
        form.action = "Registro";
        form.submit();
    }
    return z;
});


function validaDni(dni) {
    x = false;
    var numero = dni.substr(0, dni.length - 1);
    var letr = dni.substr(dni.length - 1, 1);
    numero = numero % 23;
    var letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
    letra = letra.substr(numero, 1);
    if (letra !== letr) {
        $("#error").empty();
        $("#error").append("Error en la letra del DNI deberia ser: " + letra);
        x = true;
    }
    return x;
}

$("#email").change(function () {
    $("#error").empty();
    let emailIntroducido = $(this).val();
    let patronmail = new RegExp("^[^@]+@[^@]+\.[a-zA-Z]{2,}$");
    let resultado = patronmail.test(emailIntroducido);
    if (resultado === true) {

        $.ajax({
            type: "POST",
            url: "EmailAjax",
            data: {
                parametro: "email",
                email: emailIntroducido
            },
            success: function (data) {

                if (data.tipo === 'existe') {
                    $("#email").val('');
                    $("#error").empty();
                    $("#error").append("El email ya existe en la base de datos");
                }
            },
            error: function () {
                $("#error").empty();
                $("#error").append("Error en servidor. No se pudo comprobar el email.");
                $("#email").val('');
            }
        });
    } else {
        $("#error").empty();
        $("#error").append("El formato del email no es válido.");
        $("#email").val('');
    }
});
$("#nif").change(function () {
    $("#error").empty();
    let dniIntroducido = $(this).val();

    $.ajax({
        type: "POST",
        url: "DniAjax",
        data: {
            parametro: "dni",
            dni: dniIntroducido
        },
        success: function (data) {

            if (data.tipo === 'existe') {
                $("#nif").val('');
                $("#error").empty();
                $("#error").append("Ya existe una cuneta con este dni");
            }
        },
        error: function () {
            $("#error").empty();
            $("#error").append("Error en servidor. No se pudo comprobar el email.");
            $("#nif").val('');
        }
    });
});
