===============================================================================================================================================
							SPRING SECURITY
							---------------
1. Objectives - 
	-> Secure Spring Web/REST Apps.
	-> Develop login pages (default and custom).
	-> Define users and roles with simple authentication.
	-> Protect URLs based or role.
	-> Store users, passwords, and roles in DB (plain-text -> encrypted).

2. Spring Security Model
	-> Spring Security defines a framework for security.
	-> Implemented using Servlet filters in the background.
	-> Two methods of securing a web app: Declarative and Programmatic.

3. Spring Security with Servlet Filters -
	-> Servlet Filters are used to pre-process / post-process web requests.
	-> Servlet Filters can route web requests based on security logic.
	-> Spring provides a bulk of security functionality with Servlet Filters.
	
4. Spring Security Overview -

	Web Browser <----> Spring Security Filters <----> Protected Web Resource (/myTopSecretResource)
							^
							|
							|
							--------> My App Security Configuration <----> Users, Passwords, and Roles

5. Declarative Security
	-> Define application's security constraints in configuration.
		-> All Java Config (@Configuration)
		-> or Spring XML Config
	-> Provides separation of concerns between application code and security.
	
6. Programmatic Security
	-> Spring Security provide an API for custom application coding.
	-> Provides greater customization for specific app requirements.
	
7. Different Login Methods
	-> HTTP Basic Authentication.
	-> Default Login form.
		-> Spring Security provide a default login form.
	-> Custom Login form.
		-> Your own look-and-feel, HTML+CSS+JS.

8. Authentication and Authorization
	-> In-memory.
	-> JDBC.
	-> LDAP.
	-> Custom / Pluggable.
	-> others.....

9. CSRF - Cross-Site Request Forgery
	-> Spring Security protects against CSRF.
	-> What is CSRF? - A security attack where an evil website tricks you into executing an action on a web application that 
	you are currently logged in.
	-> Spring Security's CSRF Protection -
		-> CSRF protection is enabled by default in Spring Security.
		-> Spring Security uses Synchronizer Token Pattern. Each request includes a session cookie and randomly generated token.
		-> For request processing, Spring Security verifies token before processing.
		-> All of this is handled by Spring Security Filters. 	


