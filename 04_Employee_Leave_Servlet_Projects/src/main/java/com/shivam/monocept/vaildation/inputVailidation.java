package com.shivam.monocept.vaildation;

public class inputVailidation {
	  public static String validate(String name, String id, String dept,
              String type, int days, String reason) {

if (name == null || name.trim().isEmpty()||!name.matches("[a-zA-Z ]+")) {
return "Name is required";
} 
else if (id == null || id.trim().isEmpty()||!id.matches("\\d+")) {
return "Employee ID is required";
} 
else if (dept == null || dept.trim().isEmpty()||!dept.matches("[a-zA-Z ]+")) {
return "Department is required";
} 
else if (type == null || type.trim().isEmpty()) {
return "Select leave type";
} 
else if (days < 1 || days > 10) {
return "Leave days must be between 1 and 10";
} 
else if (reason == null || reason.trim().length() < 10) {
return "Reason must be at least 10 characters";
}

return null; 
}
}
