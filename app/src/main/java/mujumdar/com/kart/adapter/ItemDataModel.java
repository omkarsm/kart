package mujumdar.com.kart.adapter;

/**
 * Created by Omkar on 1/31/2017.
 */

public class ItemDataModel {
    private String m_ItemName, m_ItemValue;

    public ItemDataModel(String itemName, String ItemValue) {
        this.m_ItemName = itemName;
        this.m_ItemValue = m_ItemValue;
    }

    public String getItemName() {
        return m_ItemName;
    }

    public String getItemValue() {
        return m_ItemValue;
    }
}
