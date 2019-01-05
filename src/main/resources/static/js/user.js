new Vue({
   el:"#abc",
   data:{
       user:{},
       userList:[],
       ids:[]
   },
    methods:{
       findAll:function(){
           var _this = this;
           axios.get("user/findAll").then(function (res) {

               console.log(res);
              _this.userList = res.data;
           }).catch(function (err) {
               console.error(err);
           });
       },
       findById:function (id) {
           var _this = this;
           axios.get("user/findById/"+id).then(function (value) {
               _this.user = value.data;
               $("#myModal").modal("show");
           })
       },
        update:function () {
           var _this = this;
           axios.post("user/update/",_this.user).then(function (value) {
                _this.findAll();
           }).catch(function (reason) {
               console.error(reason);
           })
        },
        deleteIds:function () {
            if (this.ids == null){
                return;
            }
            var _this = this;
            alert(this.ids)
            axios.get("user/delete/"+this.ids).then(function (value) {
                _this.findAll();
            }).catch(function (reason) {
                console.error(reason);
            })
        },
        save:function () {
            var _this = this;
            if (this.user != null){
                this.update();
            } else {
                axios.post("user/save/",_this.user).then(function (value) {
                    _this.findAll();
                }).catch(function (reason) {
                    console.error(reason);
                })
            }

        },
        create:function () {
            $("#myModal").modal("show");
        },
        select:function($event,id){
           if($event.target.checked){
               this.ids.push(id);
           }else {
               var index = this.ids.indexOf(id);
               this.ids.splice(index,1);
           }
        }
    },
    created:function () {
        this.findAll();
    }

});