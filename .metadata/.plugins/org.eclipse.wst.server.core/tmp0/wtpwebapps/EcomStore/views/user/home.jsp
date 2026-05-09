<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../partials/header.jsp"%>

<div class="container-3d">

	<div class="container">

		<!-- =========================================
             HERO SECTION
        ========================================== -->

		<section class="hero">

			<div class="hero-overlay"></div>

			<div class="hero-content">

				<h1>Elevate Your Style ✨</h1>

				<p>Premium Collections | Up to 65% Off</p>

				<div class="hero-btns">

					<a href="<%= request.getContextPath() %>/product" class="btn">

						Shop Now </a>

				</div>

			</div>

		</section>

		<!-- =========================================
             CATEGORY SECTION
        ========================================== -->

		<section class="categories">

			<div class="section-header">

				<h2 class="section-title">Shop by Category</h2>

				<p class="section-subtitle">Discover luxury collections curated
					for modern premium shopping experience</p>

			</div>

			<div class="category-grid">

				<!-- CLOTHES -->

				<a href="<%= request.getContextPath() %>/product?category=1"
					class="category-card">

					<div class="category-icon">👕</div>

					<h3>Clothes</h3>

					<p>Premium fashion collections</p>

				</a>

				<!-- TOYS -->

				<a href="<%= request.getContextPath() %>/product?category=2"
					class="category-card">

					<div class="category-icon">🧸</div>

					<h3>Toys</h3>

					<p>Fun & creative toys</p>

				</a>

				<!-- FOOTWEAR -->

				<a href="<%= request.getContextPath() %>/product?category=3"
					class="category-card">

					<div class="category-icon">👟</div>

					<h3>Footwear</h3>

					<p>Premium branded shoes</p>

				</a>

				<!-- ACCESSORIES -->

				<a href="<%= request.getContextPath() %>/product?category=4"
					class="category-card">

					<div class="category-icon">⌚</div>

					<h3>Accessories</h3>

					<p>Watches, bags & more</p>

				</a>

			</div>

		</section>

		<!-- =========================================
             FEATURED PRODUCTS
        ========================================== -->

		<section class="products">

			<div class="section-header">

				<h2 class="section-title">Featured Products</h2>

				<p class="section-subtitle">Trending premium products selected
					specially for you</p>

			</div>

			<div class="product-grid">

				<!-- PRODUCT CARD -->

				<div class="product-card">

					<div class="product-img-wrapper">

						<img
							src="https://images.unsplash.com/photo-1602810318383-e386cc2a3ccf"
							onerror="this.src='https://picsum.photos/300'">

					</div>

					<div class="product-info">

						<h3>Casual Shirt</h3>

						<p class="price">₹799</p>

						<a href="<%= request.getContextPath() %>/product">

							<button class="cart-btn">View Details</button>

						</a>

					</div>

				</div>

				<!-- PRODUCT -->

				<div class="product-card">

					<div class="product-img-wrapper">

						<img src="https://cdn.corenexis.com/files/c/5919449720.jpg"
							onerror="this.src='https://picsum.photos/300'">

					</div>

					<div class="product-info">

						<h3>Women Kurti</h3>

						<p class="price">₹999</p>

						<a href="<%= request.getContextPath() %>/product">

							<button class="cart-btn">View Details</button>

						</a>

					</div>

				</div>

				<!-- PRODUCT -->

				<div class="product-card">

					<div class="product-img-wrapper">

						<img src="https://cdn.corenexis.com/files/c/5745156720.jpg"
							onerror="this.src='https://picsum.photos/300'">

					</div>

					<div class="product-info">

						<h3>Kids T-Shirt</h3>

						<p class="price">₹399</p>

						<a href="<%= request.getContextPath() %>/product">

							<button class="cart-btn">View Details</button>

						</a>

					</div>

				</div>

				<!-- PRODUCT -->

				<div class="product-card">

					<div class="product-img-wrapper">

						<img src="https://cdn.corenexis.com/files/c/5696878720.jpg"
							onerror="this.src='https://picsum.photos/300'">

					</div>

					<div class="product-info">

						<h3>Toy Car</h3>

						<p class="price">₹199</p>

						<a href="<%= request.getContextPath() %>/product">

							<button class="cart-btn">View Details</button>

						</a>

					</div>

				</div>

				<!-- PRODUCT -->

				<div class="product-card">

					<div class="product-img-wrapper">

						<img src="https://cdn.corenexis.com/files/c/7536717720.jpg"
							onerror="this.src='https://picsum.photos/300'">

					</div>

					<div class="product-info">

						<h3>Running Shoes</h3>

						<p class="price">₹2499</p>

						<a href="<%= request.getContextPath() %>/product">

							<button class="cart-btn">View Details</button>

						</a>

					</div>

				</div>

				<!-- PRODUCT -->

				<div class="product-card">

					<div class="product-img-wrapper">

						<img
							src="https://images.unsplash.com/photo-1523275335684-37898b6baf30"
							onerror="this.src='https://picsum.photos/300'">

					</div>

					<div class="product-info">

						<h3>Wrist Watch</h3>

						<p class="price">₹3999</p>

						<a href="<%= request.getContextPath() %>/product">

							<button class="cart-btn">View Details</button>

						</a>

					</div>

				</div>
				<div class="product-card">
					<div class="product-img-wrapper">
						<img src="https://cdn.corenexis.com/files/c/7747124720.jpg"
							onerror="this.src='https://picsum.photos/300'">
					</div>
					<h3>Running Sneakers</h3>
					<p class="price">&#8377;2499</p>
					<a href="<%= request.getContextPath() %>/product">
						<button class="cart-btn">View Details</button>
					</a>
				</div>
				<div class="product-card">
					<div class="product-img-wrapper">
						<img src="https://cdn.corenexis.com/files/c/7133366720.jpg"
							onerror="this.src='https://picsum.photos/300'">
					</div>
					<h3>Wireless Headphones</h3>
					<p class="price">&#8377;1999</p>
					<a href="<%= request.getContextPath() %>/product">
						<button class="cart-btn">View Details</button>
					</a>
				</div>

			</div>

		</section>

	</div>

</div>

<%@ include file="../partials/footer.jsp"%>