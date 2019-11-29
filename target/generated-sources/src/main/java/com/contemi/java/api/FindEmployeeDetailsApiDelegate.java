package com.contemi.java.api;

import com.contemi.java.api.models.Employee;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * A delegate to be called by the {@link FindEmployeeDetailsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface FindEmployeeDetailsApiDelegate {

    /**
     * @see FindEmployeeDetailsApi#getEmployeeDetails
     */
    ResponseEntity<Employee> getEmployeeDetails( String  employeeId);

}
