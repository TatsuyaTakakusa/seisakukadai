package jp.ac.ohara.E.seisaku.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.E.seisaku.model.GakuseiHyou;
import jp.ac.ohara.E.seisaku.model.SeisekiHyou;
import jp.ac.ohara.E.seisaku.model.SyusekiHyou;
import jp.ac.ohara.E.seisaku.service.GakuseiService;
import jp.ac.ohara.E.seisaku.service.SeisekiService;
import jp.ac.ohara.E.seisaku.service.SyusekiService;


@Controller
public class MainController {
  @Autowired
  private GakuseiService gakuseiService;

  @Autowired
  private SeisekiService seisekiService;
  
  @Autowired
  private SyusekiService syusekiService;
 
  
  
  
  
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "こんにちは");
    return "top";
  }
  
  @GetMapping("/gakuseihyou/")
  public ModelAndView add(GakuseiHyou gakuseihyou, ModelAndView model)  {
      model.addObject("gakuseihyou", gakuseihyou);
  
  model.setViewName("gakusei");
  return model;
  
          
    }
  
  @GetMapping("/seisekihyou/")
  public ModelAndView add(SeisekiHyou seisekihyou, ModelAndView model)  {
      model.addObject("seisekihyou", seisekihyou);
  
  model.setViewName("seiseki");
  return model;
    }
  
  
  @GetMapping("/syuseki/")
  public ModelAndView add(SyusekiHyou syusekihyou, ModelAndView model)  {
      model.addObject("syusekihyou", syusekihyou);
  
  model.setViewName("syuseki");
  return model;
  }
  
  
  @GetMapping("/login/")
  public ModelAndView add2(GakuseiHyou gakuseihyou, ModelAndView model) {
      model.addObject("gakuseihyou", gakuseihyou);
      model.setViewName("login");
      return model;
      
  }
  
  @GetMapping("/hyouji/")
	public String index2(Model model) {
	model.addAttribute("list",this.gakuseiService.getGakuseiList());
	model.addAttribute("list2",this.seisekiService.getSeisekiList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "hyouji";
	}

 
  
  @PostMapping("/gakuseihyou/")
  public String gakuseihyou(@Validated @ModelAttribute @NonNull GakuseiHyou gakuseihyou, RedirectAttributes result, ModelAndView model,
		  RedirectAttributes redirectAttributes) {
	  try {
		  this.gakuseiService.save(gakuseihyou);
		  redirectAttributes.addFlashAttribute("exception", "");
		  
	  } catch (Exception e) {
		  redirectAttributes.addFlashAttribute("exception", e.getMessage());
	  }
	  return "redirect:/";
          
    }
  
  
  @PostMapping("/seisekihyou/")
  public String seisekihyou(@Validated @ModelAttribute @NonNull SeisekiHyou seisekihyou, RedirectAttributes result, ModelAndView model,
		  RedirectAttributes redirectAttributes) {
	  try {
		  this.seisekiService.save(seisekihyou);
		  redirectAttributes.addFlashAttribute("exception", "");
		  
	  } catch (Exception e) {
		  System.out.println(e.toString());
		  redirectAttributes.addFlashAttribute("exception", e.getMessage());
	  }
	  
	  return "redirect:/";
	  
          
    }
  @PostMapping("/syuseki/")
  public String syusekihyou(@Validated @ModelAttribute @NonNull SyusekiHyou syusekihyou, RedirectAttributes result, ModelAndView model,
		  RedirectAttributes redirectAttributes) {
	  try {
		  this.syusekiService.save(syusekihyou);
		  redirectAttributes.addFlashAttribute("exception", "");
		  
	  } catch (Exception e) {
		  System.out.println(e.toString());
		  redirectAttributes.addFlashAttribute("exception", e.getMessage());
	  }
	  
	  return "redirect:/";
	  
          
    }  
  




  
  
}
  
  

  