(function($) {
	getTreeModel = function(_list, _rootId, setting) {
		setting = $.extend({
			id : "id",
			parentId : "parentId",
			order : [ setting.id, "desc" ]
		}, setting);

		var _treeModel = [];
		var _listLength = _list.length;
		var _treeLength = 0;
		var _loopLength = 0;

		while (_treeLength != _listLength && _listLength != _loopLength++) {
			for (var i = 0, item; item = _list[i]; i++) {
				if (item[setting.parentId] === _rootId) {
					var view = {};
					
					for (keyArr in item) {
						view[keyArr] = item[keyArr];
					}
					
					view["children"] = [];

					_treeModel.push(view);
					_treeLength++;
					_list.splice(i, 1);

					_treeModel
					.sort(function(a, b) {
						return a[setting.order[0]] < b[setting.order[0]] ? -1
								: a[setting.order[0]] > b[setting.order[0]] ? (setting.order[1]
										.toLowerCase() === "desc" ? 1 : 0)
										: (setting
											.order[1]
											.toLowerCase() === "asc" ? 1 : 0);
					});

					break;
				}else {
					getParentNode(_treeModel, item);
				}
			}
		}

		return _treeModel;
	};
	
	function getParentNode(_children, item) {
		for (var i = 0, child; child = _children[i]; i++) {
			if (child[setting.id] === item[setting.parentId]) {
				var view = {};
				
				for (keyArr in item) {
					view[keyArr] = item[keyArr];
				}
				
				view["children"] = [];

				child.children.push(view);
				_treeLength++;
				_list.splice(_list.indexOf(item), 1);

				child
				.children
				.sort(function(a, b) {
					return a[setting.order[0]] < b[setting.order[0]] ? -1
							: a[setting.order[0]] > b[setting.order[0]] ? (setting.order[1]
									.toLowerCase() == "desc" ? 1 : 0)
									: (setting.order[1].toLowerCase() == "asc" ? 1 : 0);
				});

				break;
			}else {
				if (child.children.length) {
					arguments.callee(child.children, item);
				}
			}
		}
	}
	
	$.fn.zooTree = function(data, setting) {
		setting = $.extend({
			forceCreate : false,
			render : function(data) {
				var $a = $("<a></a>").text("");
				
				return $a;
			}
		}, setting);

		var $this = $(this);

		function createTree(jsonData, $ul) {
			if (jsonData) {
				if ($.isArray(jsonData)) {
					for (var i = 0; i < jsonData.length; i++) {
						createTreeItem(jsonData[i], $ul);
					}
				} else {
					createTreeItem(jsonData, $ul);
				}
			}
			return $ul;
		}

		function createTreeItem(jsonData, $ul) {
			var $li = $("<li></li>");

			if (jsonData) {
				$(setting.render(jsonData)).appendTo($li);

				if (jsonData.children && jsonData.children.length) {
					if (jsonData.children && jsonData.children.length) {
						var $innerUl = $("<ul></ul>");
						$(jsonData.children).each(function() {
							createTree(this, $innerUl);
						});
						$li.append($innerUl);
					}
				}
				$ul.append($li);
			}
		}

		if (setting.forceCreate) {
			var $ul = $("<ul></ul>");
			createTree(data, $ul);
			$this.append($ul);
		}

	};
})(jQuery);