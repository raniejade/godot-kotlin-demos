#ifndef KONAN_LIB3D_PLATFORMER_H
#define KONAN_LIB3D_PLATFORMER_H
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
typedef bool            lib3d_platformer_KBoolean;
#else
typedef _Bool           lib3d_platformer_KBoolean;
#endif
typedef unsigned short     lib3d_platformer_KChar;
typedef signed char        lib3d_platformer_KByte;
typedef short              lib3d_platformer_KShort;
typedef int                lib3d_platformer_KInt;
typedef long long          lib3d_platformer_KLong;
typedef unsigned char      lib3d_platformer_KUByte;
typedef unsigned short     lib3d_platformer_KUShort;
typedef unsigned int       lib3d_platformer_KUInt;
typedef unsigned long long lib3d_platformer_KULong;
typedef float              lib3d_platformer_KFloat;
typedef double             lib3d_platformer_KDouble;
typedef void*              lib3d_platformer_KNativePtr;
struct lib3d_platformer_KType;
typedef struct lib3d_platformer_KType lib3d_platformer_KType;

typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Byte;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Short;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Int;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Long;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Float;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Double;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Char;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Boolean;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_kotlin_Unit;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Bullet;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Bullet_Companion;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Coin;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_godot_Node;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Coin_Companion;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_godot_ClassMemberRegistry;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Enemy;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_godot_PhysicsDirectBodyState;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Enemy_Companion;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_FollowCamera;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_FollowCamera_Companion;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Player;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_Player_Companion;
typedef struct {
  lib3d_platformer_KNativePtr pinned;
} lib3d_platformer_kref_godot_core_Vector3;

extern void godot_gdnative_init(void* options);
extern void godot_gdnative_terminate(void* options);
extern void godot_nativescript_init(void* handle);
extern void godot_nativescript_terminate(void* handle);

typedef struct {
  /* Service functions. */
  void (*DisposeStablePointer)(lib3d_platformer_KNativePtr ptr);
  void (*DisposeString)(const char* string);
  lib3d_platformer_KBoolean (*IsInstance)(lib3d_platformer_KNativePtr ref, const lib3d_platformer_KType* type);
  lib3d_platformer_kref_kotlin_Byte (*createNullableByte)(lib3d_platformer_KByte);
  lib3d_platformer_kref_kotlin_Short (*createNullableShort)(lib3d_platformer_KShort);
  lib3d_platformer_kref_kotlin_Int (*createNullableInt)(lib3d_platformer_KInt);
  lib3d_platformer_kref_kotlin_Long (*createNullableLong)(lib3d_platformer_KLong);
  lib3d_platformer_kref_kotlin_Float (*createNullableFloat)(lib3d_platformer_KFloat);
  lib3d_platformer_kref_kotlin_Double (*createNullableDouble)(lib3d_platformer_KDouble);
  lib3d_platformer_kref_kotlin_Char (*createNullableChar)(lib3d_platformer_KChar);
  lib3d_platformer_kref_kotlin_Boolean (*createNullableBoolean)(lib3d_platformer_KBoolean);
  lib3d_platformer_kref_kotlin_Unit (*createNullableUnit)(void);

  /* User functions. */
  struct {
    struct {
      lib3d_platformer_KFloat (*deg2rad)(lib3d_platformer_KFloat y);
      void (*godot_gdnative_init_)(void* options);
      void (*godot_gdnative_terminate_)(void* options);
      void (*godot_nativescript_init_)(void* handle);
      void (*godot_nativescript_terminate_)(void* handle);
      lib3d_platformer_KFloat (*rad2deg)(lib3d_platformer_KFloat y);
      struct {
        lib3d_platformer_KType* (*_type)(void);
        lib3d_platformer_kref_Bullet (*Bullet)();
        lib3d_platformer_KBoolean (*get_disabled)(lib3d_platformer_kref_Bullet thiz);
        void (*set_disabled)(lib3d_platformer_kref_Bullet thiz, lib3d_platformer_KBoolean set);
        struct {
          lib3d_platformer_KType* (*_type)(void);
          lib3d_platformer_kref_Bullet_Companion (*_instance)();
        } Companion;
      } Bullet;
      struct {
        lib3d_platformer_KType* (*_type)(void);
        lib3d_platformer_kref_Coin (*Coin)();
        void (*onCoinBodyEntered)(lib3d_platformer_kref_Coin thiz, lib3d_platformer_kref_godot_Node node);
        struct {
          lib3d_platformer_KType* (*_type)(void);
          lib3d_platformer_kref_Coin_Companion (*_instance)();
          void (*init)(lib3d_platformer_kref_Coin_Companion thiz, lib3d_platformer_kref_godot_ClassMemberRegistry registry);
        } Companion;
      } Coin;
      struct {
        lib3d_platformer_KType* (*_type)(void);
        lib3d_platformer_kref_Enemy (*Enemy)();
        void (*_die)(lib3d_platformer_kref_Enemy thiz);
        void (*_integrate_forces)(lib3d_platformer_kref_Enemy thiz, lib3d_platformer_kref_godot_PhysicsDirectBodyState state);
        struct {
          lib3d_platformer_KType* (*_type)(void);
          lib3d_platformer_kref_Enemy_Companion (*_instance)();
          lib3d_platformer_KInt (*get_STATE_DYING)(lib3d_platformer_kref_Enemy_Companion thiz);
          lib3d_platformer_KInt (*get_STATE_WALING)(lib3d_platformer_kref_Enemy_Companion thiz);
          void (*init)(lib3d_platformer_kref_Enemy_Companion thiz, lib3d_platformer_kref_godot_ClassMemberRegistry registry);
        } Companion;
      } Enemy;
      struct {
        lib3d_platformer_KType* (*_type)(void);
        lib3d_platformer_kref_FollowCamera (*FollowCamera)();
        lib3d_platformer_KFloat (*get_angleVAdjust)(lib3d_platformer_kref_FollowCamera thiz);
        void (*set_angleVAdjust)(lib3d_platformer_kref_FollowCamera thiz, lib3d_platformer_KFloat set);
        lib3d_platformer_KFloat (*get_autoturnRayAperture)(lib3d_platformer_kref_FollowCamera thiz);
        void (*set_autoturnRayAperture)(lib3d_platformer_kref_FollowCamera thiz, lib3d_platformer_KFloat set);
        lib3d_platformer_KFloat (*get_autoturnSpeed)(lib3d_platformer_kref_FollowCamera thiz);
        void (*set_autoturnSpeed)(lib3d_platformer_kref_FollowCamera thiz, lib3d_platformer_KFloat set);
        lib3d_platformer_KFloat (*get_maxDistance)(lib3d_platformer_kref_FollowCamera thiz);
        void (*set_maxDistance)(lib3d_platformer_kref_FollowCamera thiz, lib3d_platformer_KFloat set);
        lib3d_platformer_KFloat (*get_minDistance)(lib3d_platformer_kref_FollowCamera thiz);
        void (*set_minDistance)(lib3d_platformer_kref_FollowCamera thiz, lib3d_platformer_KFloat set);
        void (*_physics_process)(lib3d_platformer_kref_FollowCamera thiz, lib3d_platformer_KFloat dt);
        void (*_ready)(lib3d_platformer_kref_FollowCamera thiz);
        struct {
          lib3d_platformer_KType* (*_type)(void);
          lib3d_platformer_kref_FollowCamera_Companion (*_instance)();
          void (*init)(lib3d_platformer_kref_FollowCamera_Companion thiz, lib3d_platformer_kref_godot_ClassMemberRegistry registry);
        } Companion;
      } FollowCamera;
      struct {
        lib3d_platformer_KType* (*_type)(void);
        lib3d_platformer_kref_Player (*Player)();
        void (*_physics_process)(lib3d_platformer_kref_Player thiz, lib3d_platformer_KFloat delta);
        void (*_ready)(lib3d_platformer_kref_Player thiz);
        struct {
          lib3d_platformer_KType* (*_type)(void);
          lib3d_platformer_kref_Player_Companion (*_instance)();
          lib3d_platformer_KInt (*get_ANIM_AIR_DOWN)(lib3d_platformer_kref_Player_Companion thiz);
          lib3d_platformer_KInt (*get_ANIM_AIR_UP)(lib3d_platformer_kref_Player_Companion thiz);
          lib3d_platformer_KInt (*get_ANIM_FLOOR)(lib3d_platformer_kref_Player_Companion thiz);
          lib3d_platformer_kref_godot_core_Vector3 (*get_CHAR_SCALE)(lib3d_platformer_kref_Player_Companion thiz);
          lib3d_platformer_KInt (*get_SHOOT_SCALE)(lib3d_platformer_kref_Player_Companion thiz);
          lib3d_platformer_KFloat (*get_SHOOT_TIME)(lib3d_platformer_kref_Player_Companion thiz);
          void (*init)(lib3d_platformer_kref_Player_Companion thiz, lib3d_platformer_kref_godot_ClassMemberRegistry registry);
        } Companion;
      } Player;
    } root;
  } kotlin;
} lib3d_platformer_ExportedSymbols;
extern lib3d_platformer_ExportedSymbols* lib3d_platformer_symbols(void);
#ifdef __cplusplus
}  /* extern "C" */
#endif
#endif  /* KONAN_LIB3D_PLATFORMER_H */
