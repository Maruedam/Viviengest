/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.utilities;


/**
 *
 * @author dwigh
 */
public class Utilidades {

    public static String capitalizar(String cadena) {
        // Separar palabras de la cadena
        String[] separadaPorEspacios = cadena.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int indice = 0; indice < separadaPorEspacios.length; indice++) {
            String palabra = separadaPorEspacios[indice];
            // De la palabra, primero agregar la primera letra ya convertida a mayúscula
            char primeraLetra = palabra.charAt(0);
            sb.append(Character.toUpperCase(primeraLetra));
            // Luego agregarle "lo sobrante" de la palabra
            sb.append(palabra.substring(1));
            // Y si no es el último elemento del arreglo, le añadimos un espacio
            if (indice < separadaPorEspacios.length - 1) {
                sb.append(" ");
            }
        }
        // Finalmente regresamos la cadena
        return sb.toString();
    }

   /* public static String cryptMD5(String textoPlano) throws NoSuchAlgorithmException {
        final char[] HEXADECIMALES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        MessageDigest msgdgt = MessageDigest.getInstance("MD5");
        byte[] bytes = msgdgt.digest(textoPlano.getBytes());
        StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            int low = (int) (bytes[i] & 0x0f);
            int high = (int) ((bytes[i] & 0xf0) >> 4);
            strCryptMD5.append(HEXADECIMALES[high]);
            strCryptMD5.append(HEXADECIMALES[low]);
        }
        return strCryptMD5.toString();
    }*/

}
