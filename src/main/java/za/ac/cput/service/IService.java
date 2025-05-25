package za.ac.cput.service;

public interface IService <T, ID> {

    T create(T t); //creates a new entity object

    T read(ID id); //read an object by its ID

    T update(T t); //updates an existing object

    boolean delete(ID id); //delete an object by its ID
}
