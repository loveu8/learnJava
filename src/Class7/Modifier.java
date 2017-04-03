package Class7;

/**
 * <pre> 
 *  修飾子整理
 *  存取權限修飾詞 (access level modifier)
 * </pre>
 */
public class Modifier{  
  
  // 公開，代表該類別產生物件時，這個屬性，誰都可以被看到
  // 給大家看，看好看滿!!
  public String iAmPublic;
  
  // 封裝(package)內及子類別(subclasses)內有效。
  // 矮唷! 朋友才看得到!
  protected String iAmProtected;
  
  // 無修飾子 封裝(package)內有效。
  // 好朋友，才看得到!
  String iAmNotModifier;
  
  // 除了類別自己可以使用外，其它類別無法存取這個資訊
  // 除了我知道，沒人知道了
  private String iAmprivate;

}