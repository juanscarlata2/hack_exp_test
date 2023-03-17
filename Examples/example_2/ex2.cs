using System.Web.Script.Serialization;

public class MyClass
{
    public string ClassName { get; set; }
    public string MethodName { get; set; }
    public string[] Parameters { get; set; }
}

// ...

public void HandleRequest(HttpContext context)
{
    var serializer = new JavaScriptSerializer();
    var json = context.Request.Form["config"];
    var config = serializer.Deserialize<MyClass>(json);

    // Use config object in application logic
    // ...
}
