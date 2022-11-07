<!-- Sidebar  -->
<nav id="sidebar">
	<div class="sidebar_blog_1">
		<div class="sidebar-header">
			<div class="logo_section">
				<a href="index.html"><img class="logo_icon img-responsive"
					src="<c:url value='/template/admin/images/logo/logo.png' />"
					alt="#" /></a>
			</div>
		</div>
		<div class="sidebar_user_info">
			<div class="icon_setting"></div>
			<div class="user_profle_side">
				<div class="user_img">
					<img class="img-responsive"
						src="<c:url value='/template/admin/images/layout_img/user_img.jpg' />"
						alt="#" />
				</div>
				<div class="user_info">
					<h6>John David</h6>
					<p>
						<span class="online_animation"></span> Online
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="sidebar_blog_2">
		<h4>General</h4>
		<ul class="list-unstyled components">
		
		
			<li>
				<a href="#top10customer" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">
					<i style="
    color: #839b00;
" class="fa fa-bar-chart"></i>
				 	<span>Top 10 Customer</span>
				 </a>
				<ul class="collapse list-unstyled" id="top10customer">
					<li><a href="<c:url value="/admin-top10?type=price" />"> <span>Spend the most money</span></a></li>
					<li><a href="<c:url value="/admin-top10?type=orders" />"> <span>The most orders</span></a></li>
				</ul>
			</li>
			
			
			<li>
				<a href="<c:url value="/admin-top10?type=product" />">
					<i style="
    color: #ae11ea;
" class="fa fa-bar-chart" aria-hidden="true"></i>
					<span>Top 10 Product HOT</span>
				</a>
			</li>
			
			
			<li><a href="#oders" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">
					<i style="
    color: #00d8ff;
" class="fa fa-truck"></i>
					<span>Orders</span>
				</a>
				<ul class="collapse list-unstyled" id="oders">
					<li><a href="<c:url value="/admin-orders?type=wait" />"> <span>Orders New</span></a></li>
					<li><a href="<c:url value="/admin-orders?type=delivery" />"> <span>Orders Delivery</span></a></li>
					<li><a href="<c:url value="/admin-orders?type=delivered" />"> <span>Orders Delivered</span></a></li>
				</ul>
			</li>
		
		
			<li>
				<a href="<c:url value="/admin-user" />">
					<i style="
    color: #e3ed9c;
" class="fa fa-user" aria-hidden="true"></i>
					<span>Customer</span>
				</a>
			</li>
		
			<li>
				<a href="#dashboard" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle"><i
					class="fa fa-align-left orange_color"></i> <span>Product Management</span></a>
				<ul class="collapse list-unstyled" id="dashboard">
					<li><a href="<c:url value="/admin-product?type=list" />"> <span>List</span></a></li>
					<li><a href="<c:url value="/admin-product?type=edit" />"> <span>Add</span></a></li>
				</ul>
			</li>
			
			
			<li>
				<a href="<c:url value="/admin-turnover" />">
					<i style="
    color: #72ff00;
" class="fa fa-pie-chart" aria-hidden="true"></i>
					<span>Turnover</span>
				</a>
			</li>
			
			<li><a href="#element" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle"><i
					class="fa fa-slideshare purple_color"></i> <span>Slide</span></a>
				<ul class="collapse list-unstyled" id="element">
					<li><a href="<c:url value="/admin-slide?type=list" />"> <span>List</span></a></li>
					<li><a href="<c:url value="/admin-slide?type=edit" />"> <span>Add</span></a></li>
				</ul>
			</li>
			
			<li><a href="#apps" data-toggle="collapse" aria-expanded="false"
				class="dropdown-toggle"><i
					class="fa fa-object-group blue2_color"></i> <span>Banner</span></a>
				<ul class="collapse list-unstyled" id="apps">
					<li><a href="<c:url value="/admin-banner?type=list" />"> <span>List</span></a></li>
					<li><a href="<c:url value="/admin-banner?type=edit" />"> <span>Add</span></a></li>
				</ul>
			</li>
			
			<li>
				<a href="<c:url value="/admin-contact" />">
					<i class="fa fa-envelope yellow_color"></i>
					<span>Contact</span>
				</a>
			</li>
			
			<li>
				<a href="#about" data-toggle="collapse" aria-expanded="false"
				class="dropdown-toggle">
				<i class="fa fa-list-alt green_color"></i>
				<span>About</span></a>
				<ul class="collapse list-unstyled" id="about">
					<li><a href="<c:url value="/admin-about?type=list" />"> <span>List</span></a></li>
					<li><a href="<c:url value="/admin-about?type=edit" />"> <span>Add</span></a></li>
				</ul>
			</li>
			
			
			<!-- <li><a href="widgets.html"><i
					class="fa fa-clock-o orange_color"></i> <span>Widgets</span></a></li>
			<li><a href="#element" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle"><i
					class="fa fa-diamond purple_color"></i> <span>Elements</span></a>
				<ul class="collapse list-unstyled" id="element">
					<li><a href="general_elements.html">> <span>General
								Elements</span></a></li>
					<li><a href="media_gallery.html">> <span>Media
								Gallery</span></a></li>
					<li><a href="icons.html">> <span>Icons</span></a></li>
					<li><a href="invoice.html">> <span>Invoice</span></a></li>
				</ul></li>
			<li><a href="tables.html"><i
					class="fa fa-table purple_color2"></i> <span>Tables</span></a></li>
			
			<li><a href="price.html"><i
					class="fa fa-briefcase blue1_color"></i> <span>Pricing
						Tables</span></a></li>
			<li><a href="contact.html"> <i
					class="fa fa-paper-plane red_color"></i> <span>Contact</span></a></li>
			<li class="active"><a href="#additional_page"
				data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
					class="fa fa-clone yellow_color"></i> <span>Additional Pages</span></a>
				<ul class="collapse list-unstyled" id="additional_page">
					<li><a href="profile.html">> <span>Profile</span></a></li>
					<li><a href="project.html">> <span>Projects</span></a></li>
					<li><a href="login.html">> <span>Login</span></a></li>
					<li><a href="404_error.html">> <span>404 Error</span></a></li>
				</ul></li>
			<li><a href="map.html"><i class="fa fa-map purple_color2"></i>
					<span>Map</span></a></li>
			<li><a href="charts.html"><i
					class="fa fa-bar-chart-o green_color"></i> <span>Charts</span></a></li>
			<li><a href="settings.html"><i
					class="fa fa-cog yellow_color"></i> <span>Settings</span></a></li> -->
		</ul>
	</div>
</nav>
<!-- end sidebar -->