package py.com.personal.cditest.business;


import py.com.personal.cditest.business.dao.Database;
import py.com.personal.cditest.model.Cuenta;
import py.com.personal.cditest.model.Usuario;
import py.com.personal.cditest.util.RequiresPermission;
import py.com.personal.cditest.util.Secured;

import javax.inject.Inject;

@Secured
public class DebitTransaction implements Transaction{

    @Inject
    LoginInfo loginInfo;

    @Inject
    Database database;

    @RequiresPermission({"Permiso1", "Permiso2"})
    public void apply(Integer monto) throws Exception {
        Usuario u = loginInfo.getLoggedUser();
        Cuenta cuenta = database.getCuentaByUsername(u.getUsername());
        if(cuenta.getSaldo()<monto){
            throw new Exception("No hay saldo suficiente para ejecutar transaccion de debito");
        }
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        System.out.println("Se hace debito, saldo final " + cuenta.getSaldo());
    }
}
