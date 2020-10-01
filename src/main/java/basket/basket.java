package basket;

import java.util.ArrayList;
import java.util.List;
import basket.Pair;
import items.item;


public class basket {
	private List< Pair<item,Integer> > basket= new  ArrayList<Pair<item,Integer>>();
	private float total=0;
	private float tax=(float) 0.24;
	private float discount=1;
	public List< Pair<item,Integer> > retrieveBasket(){
		return basket;
	}
	
	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float voucher) {
		this.discount = voucher;
	}


	@Override
	public String toString() {
		return "basket [basket=" + basket + ", total=" + total + ", tax=" + tax + ", discount=" + discount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + Float.floatToIntBits(discount);
		result = prime * result + Float.floatToIntBits(tax);
		result = prime * result + Float.floatToIntBits(total);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		basket other = (basket) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (Float.floatToIntBits(discount) != Float.floatToIntBits(other.discount))
			return false;
		if (Float.floatToIntBits(tax) != Float.floatToIntBits(other.tax))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}

	public List< Pair<item,Integer> > addToBasket(item item){
	    for (Pair<item, Integer> basketItem : basket) {
	        if (basketItem.getItem().equals(item)) {
	        	basketItem.setAmount(basketItem.getAmount()+1);
	        	total=total+item.getPrice();
	            return basket;
	        }
	    }
	    basket.add(new Pair<item,Integer>(item,1));
	    total=total+item.getPrice();
		return basket;
	}
	public List< Pair<item,Integer> > removeFromBasket(item item){
	    for (Pair<item, Integer> basketItem : basket) {
	        if (basketItem.getItem().equals(item)) {
	        	if(basketItem.getAmount()-1==0) {
	        		this.deleteFromBasket(item);
	        	}
	        	else {
	        		basketItem.setAmount(basketItem.getAmount()-1);
	        		total=total-item.getPrice();
	        	}
	            return basket;
	        }
	    }
		return basket;
	}
	public List< Pair<item,Integer> > deleteFromBasket(item item){
	    for (Pair<item, Integer> basketItem : basket) {
	        if (basketItem.getItem().equals(item)) {
	        	basket.remove(basketItem);
	        	total=total-basketItem.getAmount()*item.getPrice();
	            return basket;
	        }
	    }
		return basket;
	}


}
