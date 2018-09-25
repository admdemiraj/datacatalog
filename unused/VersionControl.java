/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.unused;

import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

import com.admir.demiraj.springbootfuultutorial2.resources.Employees;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

/**
 *
 * @author root
 */



@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllEmployees",
                                    procedureName = "get_all_employees",
        resultClasses = Employees.class)
})
public class VersionControl  implements PostUpdateEventListener{
    
    //SQL CREATE TRIGGER versioning_trigger BEFORE INSERT OR UPDATE OR DELETE ON employees FOR EACH ROW EXECUTE PROCEDURE versioning('sys_period', 'employees_history', true);
    @Override
    public void onPostUpdate(PostUpdateEvent event) {
		
                Employees employees = (Employees) event.getEntity();
            
	}

    @Override
    public boolean requiresPostCommitHanding(EntityPersister ep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
