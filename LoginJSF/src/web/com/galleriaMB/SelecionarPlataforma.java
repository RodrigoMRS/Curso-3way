package web.com.galleriaMB;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

 
@ManagedBean
public class SelecionarPlataforma {
     
    private List<String> images;
    private String option; 
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            images.add("PS4" + i + ".jpg");
        }
        for (int i = 1; i <= 5; i++) {
            images.add("XBOX" + i + ".jpg");
        }
        for (int i = 1; i <= 5; i++) {
            images.add("WIIU" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		FacesContext context = FacesContext.getCurrentInstance();
		String mensagem = "";
		if(option != null && !option.equals("")) {
		images = new ArrayList<String>();
		if(option.equalsIgnoreCase("PS4")) {
			for (int i = 1; i <= 5; i++) {
	            images.add("PS4" + i + ".jpg");
	        }
		}else if(option.equalsIgnoreCase("XboxOne")){
			 for (int i = 1; i <= 5; i++) {
		            images.add("XBOX" + i + ".jpg");
		        }
		}else if(option.equalsIgnoreCase("WiiU")) {
			for (int i = 1; i <= 5; i++) {
	            images.add("WIIU" + i + ".jpg");
	        }
		}
		mensagem = ("Plataforma "+ option +" Carregada com Sucesso!");
	}else {
		mensagem = "Todas as Plataformas Selecionadas";
	}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem));
		this.option = option;
	}
}
