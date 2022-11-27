/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function borrarDatosEspecificos(){
    
    var txtUsuario =  document.getElementById("txtUsuario");
    txtUsuario.value = "";
    
    document.getElementById("txtContrasena").value = "";
}


function resetearFormularioLogin(){
    document.getElementById("formularioLogin").reset();
}
