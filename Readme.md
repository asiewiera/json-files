Application reads json files to database and enables to communicate with Rest Api.

To create database for first application run, line: "spring.jpa.hibernate.ddl-auto=validate" in
'application.properties' file must be changed to "spring.jpa.hibernate.ddl-auto=create"

1.  Application check 'files' directory every 1 hour. If new '.json' files are available they are read and the content is written to database.



