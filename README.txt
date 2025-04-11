

- Realizar clean e install con Maven.

- Levantar el proyecto 

- Enviar un POST a la URL "http://localhost:8080/user" con el siguiente JSON:

	{
	  "name": "Juan Rodriguez",
	  "email": "juan@rodrige.com",
	  "password": "usernamed$omain1com",
	  "phones": [
	    {
	      "number": 1234567,
	      "citycode": 1,
	      "contrycode": 57
	    },
	    {
	      "number": 7654321,
	      "citycode": 11,
	      "contrycode": 45
	    }
	  ]
	}