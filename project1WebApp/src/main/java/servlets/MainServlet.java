package servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.SchoolController;
import controllers.StudentController;
import dao.SchoolDAOImpl;
import revature.orm.entitymanager.*;

public class MainServlet extends HttpServlet {

	static SchoolController schoolController = new SchoolController();
	static StudentController studentController = new StudentController();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            //if the uriTokens is exactly 3 then it also has the collection name, but no path parameter.
            case 3: {
                //Call our getAll<Insert Entity Here> methods.
                if(("schools").equals(uriTokens[2])) schoolController.getAll(request, response);
                else if(("students").equals(uriTokens[2])) studentController.getAll(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            case 4: {
                //Call our get<Insert Entity Here> by Id service method.
                request.setAttribute("id", uriTokens[3]);
                if(("schools").equals(uriTokens[2])) schoolController.getById(request, response);
                else if (("students").equals(uriTokens[2])) studentController.getById(request, response);
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            //if the uriTokens is exactly 3 then it also has the collection name, but no path parameter.
            case 3: {
                //Call our getAll<Insert Entity Here> methods.
                if (("schools").equals(uriTokens[2])) schoolController.add(request, response);
                else if(("students").equals(uriTokens[2])) studentController.add(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }

        }

	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            //if the uriTokens is exactly 3 then it also has the collection name, but no path parameter.
            case 4: {
                int id = 0;
                String input = uriTokens[3];

                if(input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number");
                    return;
                }

                request.setAttribute("id", id);
                if (("schools").equals(uriTokens[2])) schoolController.update(request, response);
                else if (("students").equals(uriTokens[2])) studentController.update(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
        
            case 4: {
            	int id = 0;
                String input = uriTokens[3];

                if(input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number");
                    return;
                }

                request.setAttribute("id", id);
                if(("schools").equals(uriTokens[2])) schoolController.delete(request, response);
                else if (("students").equals(uriTokens[2])) studentController.delete(request, response);
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }

	}

}
