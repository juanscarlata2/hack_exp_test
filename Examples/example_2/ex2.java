import com.fasterxml.jackson.databind.ObjectMapper;

public class MyClass {
    private String className;
    private String methodName;
    private String[] parameters;

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return "MyClass{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}

// ...

public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
    try {
        String json = request.getParameter("config");
        ObjectMapper objectMapper = new ObjectMapper();
        MyClass config = objectMapper.readValue(json, MyClass.class);

        // Use config object in application logic
        // ...
    } catch (IOException e) {
        // Handle exception
        // ...
    }
}
