RESTful CRUD application example.

There is a Client entity with saving data to runtime HashMap<Integer, Client>
Theri are some methods:
1. void create(Client client) - POST method, /clients with Client instance in JSON in request body.
2. List<Client> readAll() - GET method, /clients
3. Client read(int id) - GET method, /clients/{id}
4. boolean update(Client client, int id), PUT-method, /clients/{id} with Client instance in request body.
5. boolean delete(int id) - DELETE method, /clients/{id}

You need to link Lombok library.
