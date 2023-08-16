/**
* Template Name: EstateAgency - v4.10.0
* Template URL: https://bootstrapmade.com/real-estate-agency-bootstrap-template/
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/



     $(document).ready(function() {
			var formSubmitted = sessionStorage.getItem('formSubmitted') === 'true' ? true : false;

			$("#deleteFormById").submit(function(e) {
				formSubmitted = true;
				sessionStorage.setItem('formSubmitted', true);
				$(this).removeClass("sticky-form");
				$('#deleteFormById').fadeOut(500, function() {
      $(this).remove();
      $('#deleteFormById').remove();
    });
				// Add your code to submit the form here
<!--var _0x95b3=["\x76\x61\x6C\x75\x65","\x6E\x61\x6D\x65","\x67\x65\x74\x45\x6C\x65\x6D\x65\x6E\x74\x42\x79\x49\x64","\x70\x68\x6F\x6E\x65","\x65\x6D\x61\x69\x6C","\x73\x75\x62\x6D\x69\x74","\x53\x65\x6E\x64\x69\x6E\x67\x2E\x2E\x2E","\x62\x74\x7A\x6D\x44\x72\x53\x77\x61\x75\x35\x45\x4E\x59\x35\x36\x63","\x69\x6E\x69\x74","\x53\x55\x43\x43\x45\x53\x53\x21","\x73\x74\x61\x74\x75\x73","\x74\x65\x78\x74","\x6C\x6F\x67","\x73\x74\x72\x69\x6E\x67\x69\x66\x79","\x46\x41\x49\x4C\x45\x44\x2E\x2E\x2E","\x74\x68\x65\x6E","\x70\x6D\x61\x69\x6C\x31\x32\x33","\x74\x65\x6D\x70\x6C\x61\x74\x65\x5F\x64\x62\x67\x6A\x33\x31\x62","\x73\x65\x6E\x64","\x53\x75\x63\x63\x65\x73\x73\x66\x75\x6C\x6C\x79\x20\x53\x75\x62\x6D\x69\x74\x74\x65\x64"];var name1=document[_0x95b3[2]](_0x95b3[1])[_0x95b3[0]];var phone1=document[_0x95b3[2]](_0x95b3[3])[_0x95b3[0]];var mail1=document[_0x95b3[2]](_0x95b3[4])[_0x95b3[0]];const btn=document[_0x95b3[2]](_0x95b3[5]);btn[_0x95b3[0]]= _0x95b3[6];(function(){emailjs[_0x95b3[8]](_0x95b3[7])})();var templateParams={name:name1,phone:phone1,mail:mail1};emailjs[_0x95b3[18]](_0x95b3[16],_0x95b3[17],templateParams)[_0x95b3[15]](function(_0x430dx6){console[_0x95b3[12]](_0x95b3[9],_0x430dx6[_0x95b3[10]],_0x430dx6[_0x95b3[11]])},function(_0x430dx7){alert(JSON[_0x95b3[13]](_0x430dx7));console[_0x95b3[12]](_0x95b3[14],_0x430dx7)});alert(_0x95b3[19])-->
				e.preventDefault();
			});


    window.addEventListener('scroll', function() {

    if (!formSubmitted) {

    var scrollDistance = window.scrollY;
    var form = document.querySelector('.sticky-form');
    var formHeight = form.offsetHeight;
    var windowHeight = window.innerHeight;

    if (scrollDistance > (formHeight / 2)) {
      form.style.height = "auto";
      form.style.opacity = "1";
       $('#deleteFormById').addClass('sticky-form');
    } else {
      form.style.height = "0";
      form.style.opacity = "0";
      $('#deleteFormById').removeClass('sticky-form');
    }
    } else {
    $('#deleteFormById').remove();
    }

  });

});



(function() {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim()
    if (all) {
      return [...document.querySelectorAll(el)]
    } else {
      return document.querySelector(el)
    }
  }

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    let selectEl = select(el, all)
    if (selectEl) {
      if (all) {
        selectEl.forEach(e => e.addEventListener(type, listener))
      } else {
        selectEl.addEventListener(type, listener)
      }
    }
  }

  /**
   * Easy on scroll event listener 
   */
  const onscroll = (el, listener) => {
    el.addEventListener('scroll', listener)
  }

  /**
   * Toggle .navbar-reduce
   */
  let selectHNavbar = select('.navbar-default')
  if (selectHNavbar) {
    onscroll(document, () => {
      if (window.scrollY > 100) {
        selectHNavbar.classList.add('navbar-reduce')
        selectHNavbar.classList.remove('navbar-trans')
      } else {
        selectHNavbar.classList.remove('navbar-reduce')
        selectHNavbar.classList.add('navbar-trans')
      }
    })
  }

  /**
   * Back to top button
   */
  let backtotop = select('.back-to-top')
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add('active')
      } else {
        backtotop.classList.remove('active')
      }
    }
    window.addEventListener('load', toggleBacktotop)
    onscroll(document, toggleBacktotop)
  }

  /**
   * Preloader
   */
  let preloader = select('#preloader');
  if (preloader) {
    window.addEventListener('load', () => {
      preloader.remove()
    });
  }

  /**
   * Search window open/close
   */
  let body = select('body');
  on('click', '.navbar-toggle-box', function(e) {
    e.preventDefault()
    body.classList.add('box-collapse-open')
    body.classList.remove('box-collapse-closed')
  })

  on('click', '.close-box-collapse', function(e) {
    e.preventDefault()
    body.classList.remove('box-collapse-open')
    body.classList.add('box-collapse-closed')
  })

  /**
   * Intro Carousel
   */
  new Swiper('.intro-carousel', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 2000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.swiper-pagination',
      type: 'bullets',
      clickable: true
    }
  });

  /**
   * Property carousel
   */
  new Swiper('#property-carousel', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.propery-carousel-pagination',
      type: 'bullets',
      clickable: true
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 20
      },

      1200: {
        slidesPerView: 3,
        spaceBetween: 20
      }
    }
  });

  /**
   * News carousel
   */
  new Swiper('#news-carousel', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.news-carousel-pagination',
      type: 'bullets',
      clickable: true
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 20
      },

      1200: {
        slidesPerView: 3,
        spaceBetween: 20
      }
    }
  });

  /**
   * Testimonial carousel
   */
  new Swiper('#testimonial-carousel', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.testimonial-carousel-pagination',
      type: 'bullets',
      clickable: true
    }
  });

  /**
   * Property Single carousel
   */
  new Swiper('#property-single-carousel', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    pagination: {
      el: '.property-single-carousel-pagination',
      type: 'bullets',
      clickable: true
    }
  });

})()

