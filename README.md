define properties files and then configure
    - then define dynamic configuration based on env
    - define command line arg to change the properties
    - define property file in where is java file is located


microservices
    - use eureka server (it provides dynamic server url(like server-name) for api call)
    - use cloud config (for the same all server -> we can modify based on server name property file in GitHub (we can also use encryption in the credential)
        - server is change immediately
        - client is change using actuator endpoint(/refresh) to reload the bean in the server


CURD
    one to one: (provide two way adding the data) (always define the properties in child side like. mappedby -> orphanRemoval, cascade)
        - need of helper function for bidirectional mapping
        - child Eager 
        - automatic manage all things (child add, remove, update) -> based on id
        - remove child set (orphanRemoval=true)

    one to many:
        - need of helper function for bidirectional mapping
        - Child Lazy
        - automatic manage all things (child add, remove, update) -> based on id
        - remove child set (orphanRemoval=true)


============================================================

    one to one: / one to many: / many to many: (uni-directional)
        -   easy to maintain relationship  
        -   no extra code (helper function) 
        -   no need worry of recursion or data saving isuue

