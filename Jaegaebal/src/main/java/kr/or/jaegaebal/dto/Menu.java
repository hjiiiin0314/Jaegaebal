package kr.or.jaegaebal.dto;

public class Menu {
	private String MenuId;
	private String menuParent;
	private int menuLevel;
	private String menuName;
	private String menuLink;
	private int menuTarget;
	private int menuOrder;
	private int menuUse;
	private String menuIcon;
	
	public String getMenuId() {
		return MenuId;
	}
	public void setMenuId(String menuId) {
		MenuId = menuId;
	}
	public String getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}
	public int getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuLink() {
		return menuLink;
	}
	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}
	public int getMenuTarget() {
		return menuTarget;
	}
	public void setMenuTarget(int menuTarget) {
		this.menuTarget = menuTarget;
	}
	public int getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	public int getMenuUse() {
		return menuUse;
	}
	public void setMenuUse(int menuUse) {
		this.menuUse = menuUse;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	@Override
	public String toString() {
		return "Menu [MenuId=" + MenuId + ", menuParent=" + menuParent + ", menuLevel=" + menuLevel + ", menuName="
				+ menuName + ", menuLink=" + menuLink + ", menuTarget=" + menuTarget + ", menuOrder=" + menuOrder
				+ ", menuUse=" + menuUse + ", menuIcon=" + menuIcon + "]";
	}
}
