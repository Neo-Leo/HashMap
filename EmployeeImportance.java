class EmployeeImportance {
    HashMap<Integer,Employee> hm = new HashMap<>();
    
    private int helper(int id) {
        Employee e = hm.get(id);
        int importance = e.importance;
        for(int e_id : e.subordinates) {
            importance += helper(e_id); 
        }
        return importance;
    }
    
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees) {
            hm.put(e.id,e);
        }
        return helper(id);
    }
}
