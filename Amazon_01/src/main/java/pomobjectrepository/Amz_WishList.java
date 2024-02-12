package pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Kavita
 *
 */

public class Amz_WishList {
	
	 WebDriver driver;
	  //1. locating each components using @FindBy annotation
	 /**
	  * adding to the wish list
	  */
	  @FindBy(xpath="//input[@id='add-to-wishlist-button-submit']") 
	  WebElement add_to_wishlist;
	  //OR
	  @FindBy(xpath="//div[@id='add-to-wishlist-button-group']")
	  WebElement addto_wishlist;
	  
	  /**
	   * Closing the wishlist window
	   */
	 // @FindBy(xpath="//button[@class=' a-button-close a-declarative']")
	  @FindBy(xpath="(//i[@class='a-icon a-icon-close'])[2]")
	  WebElement wishlist_close;
	  /**
	   *  view wishlist
	   */
	   @FindBy(linkText="View Your List")
	   WebElement viewyourlist;
	   /**
	    *  remove the item from wish list
	    */
	   @FindBy(name="submit.deleteItem")
	   WebElement delete_wishlist_item;
	   
	   /**
	    * add to cart
	    */
	 //@FindBy(xpath="(//a[@class='a-button-text a-text-center'])[1]")
	// @FindBy(xpath="//span[@class='a-button a-button-normal a-button-primary a-button-icon wl-info-aa_add_to_cart']")
	// @FindBy(xpath="(//span[@class='a-button a-button-normal a-button-primary a-button-icon wl-info-aa_add_to_cart'])[1]")
	@FindBy(xpath="//span[@id='pab-declarative-I3QXFE2OFV55DH']")
	   WebElement addtocart;
	 /**
	    * view to cart
	    */
	 
	// @FindBy(linkText="View Cart")
	 @FindBy(xpath="(//span[@class='a-button a-button-base a-button-small g-cart-view-btn'])")
	 WebElement view_cart;
	 /**
	  * delete from cart
	  */
	 @FindBy(xpath="(//input[@class='a-color-link'])[1]")
	 WebElement delete_from_cart;
	 
	 // adding to the wishlist
	  public void addtowishlist() 
	  {
		  add_to_wishlist.click();
	  }
	  // view the wish list item
	  public void view_your_list() {
		  
		  viewyourlist.click();
	  }
	  // closing view the wishlist window
	  public void wishlist_window_close()
	  {
		  wishlist_close.click();
	  }
	  // deleting the item from wishlist 
	  public void delete_WishlistItem() 
	  {
		  delete_wishlist_item.click();
	  }
	  // adding to the cart
	  public void add_to_cart() {
		  addtocart.click();
	  }
	  // after adding to the cart , item view cart
	  public void viewcart() {
		  view_cart.click();
	  }
	  // after item  view cart next deleteing from the cart
	  public void deletefromcart() {
		  delete_from_cart.click();
	  }
	  
	//3. intilaizing each component using page factory class

	  public Amz_WishList(WebDriver driver)
	  {
		  PageFactory.initElements(driver,this);
	  }


}
