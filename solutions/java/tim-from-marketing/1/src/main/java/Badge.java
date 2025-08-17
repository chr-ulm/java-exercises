class Badge {
    public String print(Integer id, String name, String department) {
        String idSegment = (id == null) ? "" : "[" + id + "] - ";
        String title = (department == null) ? "OWNER" : department.toUpperCase();
        return idSegment + name + " - " + title;
    }
}
