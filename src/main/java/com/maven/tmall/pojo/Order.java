package com.maven.tmall.pojo;

import java.util.Date;
import java.util.List;

import com.maven.tmall.service.OrderService;

public class Order {
	private Integer id;

	private String orderCode;

	private String address;

	private String post;

	private String receiver;

	private String mobile;

	private String userMessage;

	private Date createDate;

	private Date payDate;

	private Date deliveryDate;

	private Date confirmDate;

	private Integer uid;

	private String status;

	/* 如下是非数据库字段 */
	// 该订单下的订单项列表
	private List<OrderItem> orderItems;

	// 该订单对应的用户
	private User user;

	// 该订单的总计金额
	private float total;

	// 该订单的总计数量
	private int totalNumber;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode == null ? null : orderCode.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post == null ? null : post.trim();
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver == null ? null : receiver.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage == null ? null : userMessage.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	// 用于把英文表达的Status信息转换为中文
	public String getStatusDesc() {
		String desc = "未知";

		switch (status) {
		case OrderService.waitPay:
			desc = "待付款";
			break;
		case OrderService.waitDelivery:
			desc = "待发货";
			break;
		case OrderService.waitConfirm:
			desc = "待收货";
			break;
		case OrderService.waitReview:
			desc = "等评价";
			break;
		case OrderService.finish:
			desc = "完成";
			break;
		case OrderService.delete:
			desc = "刪除";
			break;
		default:
			desc = "未知";
		}
		return desc;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderCode=" + orderCode + ", address=" + address + ", post=" + post
				+ ", receiver=" + receiver + ", mobile=" + mobile + ", userMessage=" + userMessage + ", createDate="
				+ createDate + ", payDate=" + payDate + ", deliveryDate=" + deliveryDate + ", confirmDate="
				+ confirmDate + ", uid=" + uid + ", status=" + status + ", orderItems=" + orderItems + ", user=" + user
				+ ", total=" + total + ", totalNumber=" + totalNumber + "]";
	}

}