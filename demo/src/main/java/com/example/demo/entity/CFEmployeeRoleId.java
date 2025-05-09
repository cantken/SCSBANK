package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CFEmployeeRoleId implements Serializable {
	@Id
    private String empNo;
	@Id
    private String roleNo;

    // equals & hashCode 必須實作
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CFEmployeeRoleId)) return false;
        CFEmployeeRoleId that = (CFEmployeeRoleId) o;
        return Objects.equals(empNo, that.empNo) &&
               Objects.equals(roleNo, that.roleNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, roleNo);
    }
}
