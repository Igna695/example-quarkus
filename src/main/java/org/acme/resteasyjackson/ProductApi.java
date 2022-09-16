package org.acme.resteasyjackson;

import org.acme.entity.Product;
import org.acme.repository.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductApi {
 @Inject
    ProductRepository pr;

    @GET
    public List<Product> list() {
        return pr.listProduct();
    }

    @POST
    public Response add(Product p) {
        pr.createdProduct(p);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Product p) {
       pr.deleteProduct(p);
        return Response.ok().build();
    }


}
