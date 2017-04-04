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
        
        VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
		service.setAPIKey("{""url": "https://gateway-a.watsonplatform.net/visual-recognition/api",
						     "api_key": "be542628436545954bf7f34c3669ccf89e218bb0" "}");
		System.out.println("Classify an image");
		ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(new File("image/1081.jpg")).build();
		VisualClassification result = service.classify(options).execute();
		System.out.println(result);				    
						    
    }

}
