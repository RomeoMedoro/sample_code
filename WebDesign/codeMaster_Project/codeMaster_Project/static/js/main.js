/*Sticky Navbar*/
$(document).ready(function(){
	var stickyNav = $('#nav-row').offset().top;
	$(window).scroll(function() {  
		if ($(window).scrollTop() > stickyNav) {
			$('#nav-row').addClass('fixed');
		}
		else {
			 $('#nav-row').removeClass('fixed');
		}  
	});
});

/*rotating images*/
$(document).ready(function() {
	$('#image-rotate img:gt(0)').hide(); // to hide all but the first image when page loads
	setInterval(function(){
		$('#image-rotate :first-child').fadeOut()
		.next().fadeIn().end().appendTo('#image-rotate');
	},4000);        
});

/* internal navigation bar*/
$(document).ready(function(){
	$('.internal-nav a').click(function() {
		$('.site-hidden').hide();	
		$(this.getAttribute('href')).show();   
	});
});


$(document).ready(function(){
	$('.mobile-nav a').click(function() {
		$(this.getAttribute('href')).toggle();   
	});
});

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
	if (!event.target.matches('.dropbtn')) {

		var dropdowns = document.getElementsByClassName("dropdown-content");
		var i;
		for (i = 0; i < dropdowns.length; i++) {
			var openDropdown = dropdowns[i];
			if (openDropdown.classList.contains('show')) {
				openDropdown.classList.remove('show');
			}
		}
	}
}

function internalNav() {
	document.getElementById("internalDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
	if (!event.target.matches('.internal-dropbtn')) {

		var dropdowns = document.getElementsByClassName("internal-content");
		var i;
		for (i = 0; i < dropdowns.length; i++) {
			var openDropdown = dropdowns[i];
			if (openDropdown.classList.contains('show')) {
				openDropdown.classList.remove('show');
			}
		}
	}
}



function StringStream(string) {
	this.pos = 0;
	this.string = string;
}

StringStream.prototype = {
	done: function() {return this.pos >= this.string.length;},
	peek: function() {return this.string.charAt(this.pos);},
	next: function() {
		if (this.pos < this.string.length)
			return this.string.charAt(this.pos++);
},
eat: function(match) {
    var ch = this.string.charAt(this.pos);
    if (typeof match == "string") var ok = ch == match;
    else var ok = ch && match.test ? match.test(ch) : match(ch);
    if (ok) {this.pos++; return ch;}
},
eatWhile: function(match) {
    var start = this.pos;
    while (this.eat(match));
    if (this.pos > start) return this.string.slice(start, this.pos);
},
backUp: function(n) {this.pos -= n;},
column: function() {return this.pos;},
eatSpace: function() {
    var start = this.pos;
    while (/\s/.test(this.string.charAt(this.pos))) this.pos++;
    return this.pos - start;
},
match: function(pattern, consume, caseInsensitive) {
    if (typeof pattern == "string") {
		function cased(str) {return caseInsensitive ? str.toLowerCase() : str;}
		if (cased(this.string).indexOf(cased(pattern), this.pos) == this.pos) {
			if (consume !== false) this.pos += str.length;
			return true;
		}
	}
    else {
		var match = this.string.slice(this.pos).match(pattern);
		if (match && consume !== false) this.pos += match[0].length;
		return match;
	}
}
};


window.onload = function() {
	var editor = CodeMirror(document.getElementById("html-container"), {
		mode: "htmlmixed",
		theme: "monokai",
		lineWrapping: true,
		htmlhint: true,
		lineNumbers: true,
		styleActiveLine: true,
		parsefile: "parsejavascript.js",
		matchBrackets: true,
		autoCloseBrackets: true,
		matchTags: true,
		showTrailingSpace: true,
		highlightSelectionMatches: true,
		ling: true,
		extraKeys: {"Ctrl-Space": "autocomplete"},
		value: "<div>\n</div>\n\n<style>\n</style>\n\n<script type='text/javascript'>\nfunction myFunction(){\n}\n</script>",
		foldGutter: {
                        rangeFinder: new CodeMirror.fold.combine(CodeMirror.fold.brace, CodeMirror.fold.comment)
                    },
		onKeyEvent: function(editor) {
			 var frame= $('iframe'),
				contents = frame.contents(),
				body = contents.find('body');
				body.html(editor.getValue());
				
				
        }
	});
}

$(document).ready(function() {
	$('#hide2, #hide3, #hide4, #hide5').hide();
	$('#next').click(function(){
		 //code
		var curr = $(".tutorial:visible");
		curr.next(".tutorial").show();
		curr.hide();
	});
});

$(document).ready(function(){
	$('.tutorial a').click(function() {
		$('.hints').hide();	
		$(this.getAttribute('href')).show();   
	});
});

	