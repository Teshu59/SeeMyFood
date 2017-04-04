package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("Hello test World!");
        
        VisualRecognition service = new VisualRecognition();
		service.setAPIKey("{
  							"url": "https://gateway-a.watsonplatform.net/visual-recognition/api",
  							"note": "It may take up to 5 minutes for this key to become active",
							"api_key": "be542628436545954bf7f34c3669ccf89e218bb0"
						    "}");
		System.out.println("Classify an image");
		ClassifyImagesOptions options = new ClassifyImagesOptions.Builder()
    	.images(new File("src/image1081.jpg"))
    	.build();
		VisualClassification result = service.classify(options).execute();
		System.out.println(result);				    
						    
    }

}
